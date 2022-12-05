#! /bin/bash
if [ $# -ne 1 ]
then
    echo “SYNTAXE : $0 répertoire”
else
    echo 'ls -la $1'
    echo $?
    echo "ls -la $1"
    echo $?
    echo `ls -la $1`
    echo $?
    echo $(ls -la $1)
    echo $?
fi
