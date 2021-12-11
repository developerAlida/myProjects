package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import com.techelevator.services.RestCatFactService;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@RestController
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(path="/api/cards", method = RequestMethod.GET)
    public List<CatCard>  getAllCatCards() {
        List<CatCard> catCardList = catCardDao.list();
        return catCardList;
    }

    /**
     * GET /api/cards/{id}: Provides a Cat Card with the given ID.
     */
    @RequestMapping(path="/api/cards/{id}", method = RequestMethod.GET)
    public CatCard getCatCardById(@PathVariable long id) {
        return catCardDao.get(id);
    }

    /**
     * GET /api/cards/random: Provides a new, randomly created Cat Card containing information
     *   from the cat fact and picture services.
     */
    @RequestMapping(path="/api/cards/random", method = RequestMethod.GET)
    public CatCard createRandomCatCard(){
        CatCard random = new CatCard();
        Random rand = new Random(); //instance of random class
        int upperbound = 100;
        int randomId = rand.nextInt(upperbound);
        Long id = (long) randomId;
        String catFact = catFactService.getFact().getText();
        String imgUrl = catPicService.getPic().getFile(); // this is the URL
        String caption = "";
        random.setCatCardId(id);
        random.setCatFact(catFact);
        random.setImgUrl(imgUrl);
        random.setCaption(caption);
        return random;
    }


    /**
     *     POST /api/cards: Saves a card to the user's collection.
     */
    @RequestMapping(path = "/api/cards", method = RequestMethod.POST)
    public boolean createCard(@RequestBody CatCard catCard) {
        return catCardDao.save(catCard);
    }

    /**PUT /api/cards/{id}: Updates a card in the user's collection.
     */
    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.PUT)
    public boolean updateCatCard(@PathVariable @Valid long id, @RequestBody CatCard catCard)
            throws CatCardNotFoundException{
        return catCardDao.update(id, catCard);
    }

    //DELETE /api/cards/{id}: Removes a card from the user's collection.
    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        catCardDao.delete(id);
    }

}


