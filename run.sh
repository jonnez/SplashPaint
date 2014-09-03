#!/bin/bash

echo "Number of characters in SplashPaint and its minified version S:"
wc -c *.java

echo "Running readable version:"
javac -nowarn SplashPaint.java && java SplashPaint < painting.txt

echo "Running minified version:"
javac -nowarn S.java && java S < painting.txt

