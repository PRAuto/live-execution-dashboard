

#!/bin/bash
nohup java -jar /home/ec2-user/javaapp/live-execution-dashboard-0.0.1-SNAPSHOT.jar > /home/ec2-user/javaapp/log.txt 2>&1 &
echo $! > /home/ec2-user/javaapp/pid.file
