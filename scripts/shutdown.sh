#!/bin/bash
#kill the last run process
FILE=/home/ec2-user/javaapp/pid.file
if [ -f "$FILE" ]; then
    echo "$FILE exists."
    kill $(cat "$FILE")
fi

