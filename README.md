# gke-jenkins
gke-jenkins

```
kubectl port-forward --namespace jenkins $(kubectl get pod --namespace jenkins --selector="app.kubernetes.io/component=jenkins-master,app.kubernetes.io/name=jenkins-1" --output jsonpath='{.items[0].metadata.name}') 8080:8080
kubectl -n jenkins get secret jenkins-token-855r5 -o jsonpath={.data.token} | base64 -d
```

```
minikube addons enable ingress
minikube service jenkins --url
```

## Notes
- docker run --rm -it  --add-host host.docker.internal:host-gateway centos sh
- host.minikube.internal
