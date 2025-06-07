#!/bin/sh
if [ "$(whoami)" = "java" ]; then
      echo "Running as java user"
      ./opt/bash
    else
      exit 1;
    fi
