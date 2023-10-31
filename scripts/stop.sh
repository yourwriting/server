#!/bin/bash

ROOT_PATH="/home/ubuntu/spring-github-action"
JAR="$ROOT_PATH/application.jar"
STOP_LOG="$ROOT_PATH/stop.log"
SERVICE_PID=$(pgrep -f $JAR)

if [ -z "$SERVICE_PID" ]; then
  echo "Service Not Found" >> $STOP_LOG
else
  echo "Service ends" >> $STOP_LOG
  kill "$SERVICE_PID"
fi