#
# WSO2 API Manager 1.10.0
#
FROM java:latest
MAINTAINER Brian Du Preez, bdupreez@gmail.com

ADD wso2am-1.10.0
RUN wget -P /opt https://s3-us-west-2.amazonaws.com/wso2-stratos/wso2am-1.10.0.zip && \
    apt-get update && \
    apt-get install -y zip && \
    apt-get clean && \
    unzip /opt/wso2am-1.9.1.zip -d /opt && \
    rm /opt/wso2am-1.9.1.zip

EXPOSE 9443 9763 8243 8280 10397 7711
ENTRYPOINT ["/opt/wso2am-1.9.1/bin/wso2server.sh"]