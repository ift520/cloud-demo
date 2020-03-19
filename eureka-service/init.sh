#!/bin/bash
suffix=svc.cluster.local
EUREKA_HOSTNAME="$POD_NAME.$SERVICE_NAME.$POD_NAMESPACE.$suffix"
REGISTER_WITH_EUREKA="true"
FETCH_REGISTRY="true"
if [ $EUREKA_REPLICAS = 1 ]; then
    echo "The Replicas of Eureka Pod Only One"
    REGISTER_WITH_EUREKA="false"
    FETCH_REGISTRY="false"
    EUREKA_URL_LIST="http://$EUREKA_HOST_NAME:$EUREKA_PORT/eureka/"
    echo "The EUREKA_URL_LIST is $EUREKA_URL_LIST"
else
    echo "The Replicas of Eureka Pod is $EUREKA_REPLICAS"
    for ((i = 0; i<$EUREKA_REPLICAS; i++));
    do
        if [ ${POD_NAME##*-} = $i ]
        then
            continue;
        fi
        temp="http://$EUREKA_APPLICATION_NAME-$i.$SERVICE_NAME.$POD_NAMESPACE.$suffix:$EUREKA_PORT/eureka/,"
        EUREKA_URL_LIST="$EUREKA_URL_LIST$temp"
        echo $EUREKA_URL_LIST
    done
fi
EUREKA_URL_LIST=${EUREKA_URL_LIST%?}
export EUREKA_HOSTNAME=$EUREKA_HOSTNAME
export EUREKA_URL_LIST=$EUREKA_URL_LIST
export REGISTER_WITH_EUREKA=$REGISTER_WITH_EUREKA
export FETCH_REGISTRY=$FETCH_REGISTRY
echo "start jar"
java -jar /usr/home/app.jar --spring.profiles.active=prod