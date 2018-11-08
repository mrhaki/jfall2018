#!/bin/sh

mn create-app jfall.hello --features=graal-native-image
cp build-native.sh hello/
