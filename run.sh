#!/bin/bash

echo "Number of characters in SplashPaint and its minified version S:"
wc -c *.java

for class in SplashPaint S
do
    echo "Compiling $class"
    if ! javac -nowarn $class.java; then exit; fi

    for painting in painting*.txt
    do
        echo "Running $class on $painting"
        java $class < $painting
    done
done
