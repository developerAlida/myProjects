#!/bin/bash
export PGPASSWORD='postgres1'

psql -U postgres -f "dropdb.sql" &&
psql -U postgres -d catcards -f "schema.sql" &&
psql -U postgres -d catcards -f "user.sql" 
