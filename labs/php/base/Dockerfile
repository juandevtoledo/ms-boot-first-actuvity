FROM ubuntu:16.04

RUN apt-get update && apt-get install -y apt-cacher-ng
RUN apt-cache pkgnames | grep php7.0

RUN  apt-get install -y apache2 && \
                        apt-get install -y php7.0 \
                        libapache2-mod-php7.0 \
                        php7.0-cli \ 
                        php7.0-common \
                        php7.0-mbstring \
                        php7.0-gd \
                        php7.0-intl \
                        php7.0-xml \
                        php7.0-mysql \
                        php7.0-mcrypt\
                         php7.0-zip


RUN  apt-get install -y php-curl \
    &&  apt-get install -y unzip \
    && apt-get install  -y php-dev php-pear build-essential libaio1 \
    && apt-get install php-dev \
    && apt-get install php7.0-dev

COPY instantclient-basic-linux.x64-12.2.0.1.0.zip  /opt/oracle/instantclient-basic-linux.x64-12.2.0.1.0.zip
COPY instantclient-sdk-linux.x64-12.2.0.1.0.zip    /opt/oracle/instantclient-sdk-linux.x64-12.2.0.1.0.zip
COPY instantclient-sqlplus-linux.x64-12.2.0.1.0.zip   /opt/oracle/instantclient-sqlplus-linux.x64-12.2.0.1.0.zip
COPY oci8-2.2.0.tgz /opt/oracle/oci8-2.2.0.tgz
WORKDIR /opt/oracle

RUN unzip instantclient-basic-linux.x64-12.2.0.1.0.zip \
    && unzip instantclient-sdk-linux.x64-12.2.0.1.0.zip \
    && unzip instantclient-sqlplus-linux.x64-12.2.0.1.0.zip \
    && ln -s /opt/oracle/instantclient_12_2/libclntsh.so.12.1 /opt/oracle/instantclient_12_2/libclntsh.so \
    && ln -s /opt/oracle/instantclient_12_2/libocci.so.12.1 /opt/oracle/instantclient_12_2/libocci.so \
    && echo /opt/oracle/instantclient_12_2 > /etc/ld.so.conf.d/oracle-instantclient \
    && tar -xzf oci8-2.2.0.tgz
##RUN pecl install oci8 -with-oci8=shared,instantclient,/opt/oracle/instantclient_12_2

WORKDIR /opt/oracle/oci8-2.2.0
RUN phpize 
RUN ./configure --with-oci8=instantclient,/opt/oracle/instantclient_12_2 
RUN make install 
WORKDIR /opt/oracle

#RUN php -m | grep 'oci8'
RUN echo "extension = oci8.so" >> /etc/php/php.ini \
    && echo "extension = oci8.so" >> /etc/php/7.0/apache2/php.ini \
    && echo "extension = oci8.so" >> /etc/php/7.0/cli/php.ini \
    && echo "extension = php_curl.dll" >> /etc/php/php.ini \
    && echo "extension = php_curl.dll" >> /etc/php/7.0/apache2/php.ini \ 
    && echo "extension = php_curl.dll" >> /etc/php/7.0/cli/php.ini \
    && echo "export TNS_ADMIN=/opt/oracle/instantclient_12_2" >> /etc/apache2/envvars \
    && echo "export LD_LIBRARY_PATH=/opt/oracle/instantclient_12_2" >> /etc/apache2/envvars \
    && echo "export ORACLE_HOME=/opt/oracle/instantclient_12_2" >> /etc/apache2/envvars \
    && echo "variables_order = \"EGPCS\"" >> /etc/php/php.ini \
    && echo "variables_order = \"EGPCS\"" >> /etc/php/7.0/apache2/php.ini \
    && echo "variables_order = \"EGPCS\"" >> /etc/php/7.0/cli/php.ini

COPY entrypoint.sh /sbin/entrypoint.sh 
RUN chmod 755 /sbin/entrypoint.sh 

RUN rm instantclient-basic-linux.x64-12.2.0.1.0.zip \
&& rm instantclient-sdk-linux.x64-12.2.0.1.0.zip   \
&& rm instantclient-sqlplus-linux.x64-12.2.0.1.0.zip \ 
&& rm oci8-2.2.0.tgz

WORKDIR /var/www/html
RUN rm index.html
CMD ["/sbin/entrypoint.sh"]
# docker build -t edumar111/php-base:1.0.0 -f Dockerfile .
# docker push     edumar111/php-base:1.0.0
