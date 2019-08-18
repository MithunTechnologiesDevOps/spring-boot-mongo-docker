---
apiVersion: v1
kind: ReplicationController
metadata:
  labels:
    name: javawebapp
  name: java-controller
spec:
  replicas: 1
  template:
    metadata:
      labels:
        name: javawebapp
    spec:
      containers:
      - image: dockerhandson/java-web-app
        name: javawebapp
        ports:
        - name: javawebapp
          containerPort: 8080  
---
# Node Port Service
apiVersion: v1
kind: Service
metadata:
  labels:
    name: javawebapp
  name: javawebapp
spec:
  type: NodePort
  ports:
    - port: 8080
      targetPort: 8080
  selector:
    name: javawebapp
