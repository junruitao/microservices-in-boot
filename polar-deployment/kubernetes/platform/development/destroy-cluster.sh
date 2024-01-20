#!/bin/sh

echo "\n🏴️ Destroying Kubernetes cluster...\n"

minikube stop --profile voyager

minikube delete --profile voyager

echo "\n🏴️ Cluster destroyed\n"
