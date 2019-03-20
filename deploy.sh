docker build -t hyde009/hml:latest -t hyde009/hml:$SHA -f ./hml/Dockerfile.dev ./hml
docker build -t hyde009/hml-naming-server:latest -t hyde009/hml-naming-server:$SHA -f ./hml-naming-server/Dockerfile.dev ./hml-naming-server
docker build -t hyde009/hml-ronswanson-quotes:latest -t hyde009/hml-ronswanson-quotes:$SHA -f ./hml-ronswanson-quotes/Dockerfile.dev ./hml-ronswanson-quotes
docker build -t hyde009/hml-zuul-api:latest -t hyde009/hml-zuul-api:$SHA -f ./hml-zuul-api/Dockerfile.dev ./hml-zuul-api

docker push hyde009/hml:latest
docker push hyde009/hml-naming-server:latest
docker push hyde009/hml-ronswanson-quotes:latest
docker push hyde009/hml-zuul-api:latest

docker push hyde009/hml:$SHA
docker push hyde009/hml-naming-server:$SHA
docker push hyde009/hml-ronswanson-quotes:$SHA
docker push hyde009/hml-zuul-api:$SHA

kubectl apply -f k8s
kubectl set image deployments/homework-log homework-log=hyde009/hml:$SHA
kubectl set image deployments/hmlnaming hmlnaming=hyde009/hml-naming-server:$SHA
kubectl set image deployments/ron-deployment hmlron=hyde009/hml-ronswanson-quotes:$SHA
kubectl set image deployments/api-gateway api-gateway=hyde009/hml-zuul-api:$SHA