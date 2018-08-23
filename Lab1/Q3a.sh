# ! /bin/bash

read -p "Enter the argument : " arg

if [[ -d $arg ]]; then
	echo "$arg is a directory"
elif [[ -f $arg ]]; then 
	echo "$arg is a file"
else
	echo "$arg is something else"

fi	
