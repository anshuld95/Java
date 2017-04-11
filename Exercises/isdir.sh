#!/bin/sh

if [[ $# -ne 1 ]]; then
	echo "Usage: $0 dir"
	exit 1
fi

dirname=$1

if [[ -e "$dirname" ]] || [[ -d "$dirname" ]]	
then
	if [[ ! -d "$dirname" ]]
	then 
		echo "Error: directory $dirname not found."
		exit 3
	else
		echo "$dirname is a directory"
	fi
else
	echo "Error: No such file or directory exists"
	exit 2
fi