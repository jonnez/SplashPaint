#!/bin/bash

#SplashPaint S D1 D2 D
for class in SplashPaint S
do
    echo "Compiling $class, number of characters is:"
    wc -c $class.java

    if ! javac -nowarn $class.java; then exit; fi

    for painting in painting*.txt
    do
        echo "Running $class on $painting"

        sol=$(basename $painting .txt).sol
        expected=$(cat $sol)
        actual=$(java $class < $painting)

        if [ "$expected" != "$actual" ]
        then
            echo "Solution incorrect for $class and $painting"
            echo "Expected: $expected"
            echo "Actual:   $actual"
            exit
        fi
    done
done
