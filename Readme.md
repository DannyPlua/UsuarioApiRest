echo "# UsuarioApiRest" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/DannyPlua/UsuarioApiRest.git
git push -u origin main

#url servicio rest
http://localhost:8001/personas/post-listar-personas

http://localhost:8001/personas/post-listar-personaid
#parametros de entrada 
{
	"idPersona":1
}

http://localhost:8001/personas/post-inserta-persona
#parametros de entrada 
{
	"nombre":"Danny",
	"apellido":"Plua",
	"edad":"30",
	"fechaNac":"1988-11-03",
	"direccion":"Lomas de San Pedro",
	"correo":"danny_plua@hotmail.com",
	"idPersonas":1
}


http://localhost:8001/personas/post-actualiza-persona
#parametros de entrada 
{
	"nombre":"Danny F",
	"apellido":"Plua R",
	"edad":"33",
	"fechaNac":"1988-11-03",
	"direccion":"Lomas de San Pedro",
	"correo":"danny_plua@hotmail.com",
	"idPersonas":1
}
