# POSTGRESQL
docker run -itd -e POSTGRES_USER=alaa -e POSTGRES_PASSWORD=alaa -p 5432:5432 --name postgresql postgres

# PGADMIN  
docker run --name pgadmin -p 5051:5051 -e "PGADMIN_DEFAULT_EMAIL=ammar.alaaeddine@gmail.com"  -e "PGADMIN_DEFAULT_PASSWORD=alaa" -d dpage/pgadmin4

# Test Authentication
curl -d '{"userName":"tarik@g.com", "password":"tariktariktariktarik"}' -X POST http://localhost:8086/rest/authentication -H "Content-Type: application/json"

