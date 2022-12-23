FROM postgres:14.3
USER postgres
RUN whoami
ADD init.sql /docker-entrypoint-initdb.d/
ENTRYPOINT ["docker-entrypoint.sh"]
EXPOSE 7770
CMD ["postgres"]