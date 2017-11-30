#!/bin/bash

echo "Applying migration $pluralModel;format="snake"$"

echo "Adding routes to conf/app.routes"

echo "" >> ../conf/app.routes
echo "GET        /$pluralModel;format="decap"$               controllers.$pluralModel$Controller.index" >> ../conf/app.routes

echo "Migration $pluralModel;format="snake"$ completed"
