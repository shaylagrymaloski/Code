#!/bin/bash

make

for test in {0..9}
do
    ./mtf2text2 test0$test.mtf>output.txt
    diff test0$test.txt tests/test0$test.txt
    if [ $? -ne 0 ]; then
        echo "Does not match test0$test";
    else
        echo "passed test0$test";
    fi
done

for test in {10..19}
do
    ./mtf2text2 test$test.mtf>output.txt
    diff test$test.txt tests/test$test.txt>output.txt
    if [ $? -ne 0 ]; then
        echo "Does not match test$test";
    else
        echo "passed test$test";
    fi
done
