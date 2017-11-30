#!/bin/bash

echo "Applying migration $modelName;format="snake"$"

echo "Adding routes to conf/app.routes"

echo "" >> ../conf/app.routes
echo "GET        /$modelName;format="decap"$               controllers.$controllerName;format="Camel"$Controller.get$modelName;format="Camel"$" >> ../conf/app.routes

echo "Migration $modelName;format="snake"$ completed"
