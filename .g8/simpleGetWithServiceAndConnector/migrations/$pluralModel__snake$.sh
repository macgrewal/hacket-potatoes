#!/bin/bash

echo "Applying migration $controllerName;format="snake"$"

echo "Adding routes to conf/app.routes"

echo "" >> ../conf/app.routes
echo "GET        /$controllerName;format="decap"$               controllers.$controllerName;format="Camel"$Controller.index" >> ../conf/app.routes

echo "Migration $controllerName;format="snake"$ completed"
