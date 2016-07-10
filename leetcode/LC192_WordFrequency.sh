#!/bin/bash

cat words.txt | tr '\n' ' ' | sed 's/ \+/\n/g' | sort | uniq -c | sed 's/^ \+//g' | sort -nr | sed 's/\([0-9]*\) \(.*\)/\2 \1/g'
