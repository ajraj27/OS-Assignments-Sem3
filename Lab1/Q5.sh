# ! /bin/bash

read -p "Enter the no : " num

if (($num % 2)); then
	echo "$num is odd"
else
	echo "$num is even"

fi	
