#memcache
kubectl apply -f /c/Users/Kubernetes_p/Memcache/memcache-deployment.yaml

#db
kubectl apply -f /c/Users/Kubernetes_p/db-deployment.yaml

sleep 30s

#memcache
kubectl apply -f /c/Users/Kubernetes_p/Memcache/memcache-service.yaml
#db
kubectl apply -f /c/Users/Kubernetes_p/db-service.yaml

sleep 10s

#hrsystem
kubectl apply -f /c/Users/Kubernetes_p/hrsystem-deployment.yaml

#cesystem
kubectl apply -f /c/Users/Kubernetes_p/cesystem-deployment.yaml

#ausystem
kubectl apply -f /c/Users/Kubernetes_p/ausystem-deployment.yaml

#frontend
kubectl apply -f /c/Users/Kubernetes_p/frontend-deployment.yaml
sleep 30s


#hrsystem
kubectl apply -f /c/Users/Kubernetes_p/hrsystem-service.yaml
#ausystem
kubectl apply -f /c/Users/Kubernetes_p/ausystem-service.yaml
#cesystem
kubectl apply -f /c/Users/Kubernetes_p/cesystem-service.yaml
#frontend
kubectl apply -f /c/Users/Kubernetes_p/frontend-service.yaml
sleep 10s

#assystem
kubectl apply -f /c/Users/Kubernetes_p/assystem-deployment.yaml
sleep 30s
#assystem
kubectl apply -f /c/Users/Kubernetes_p/assystem-service.yaml