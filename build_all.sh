#!/usr/bin/env sh
set -e
cd ejercicio1
mvn test
cd ../ejercicio2/cucumber-java-skeleton
mvn test