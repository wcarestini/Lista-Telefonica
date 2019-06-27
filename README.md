<h1> Lista-Telefonica</h1>
<hr>
<p>O projeto consiste em uma lista telefônica web, onde você pode adicionar contatos, excluir, editar e também filtrar de acordo com os campos preenchidos. </p>
<hr>
<h3>Tecnologias utilizadas:</h3>
<ul>
	<li>Banco MySQL</li>
	<li>Java 8</li>
	<li>Spring MVC</li>
	<li>Maven</li>
	<li>Hibernate</li>
</ul>
<hr>
<h3>Instruções para rodar o projeto</h3>
<p>Para facilitar o processo, diponibilizei <a href="https://drive.google.com/open?id=1-mz22NjwA1mbX7z4lxkoT3ZZOBKinXnF">aqui</a> o arquivo war do projeto, basta fazer o download do war e também do Tomcat <a href="https://tomcat.apache.org/download-90.cgi">por aqui</a>, após fazer o download do Tomcat basta extrai-lo, ir até a pasta webapps (o caminho fica "~/apache-tomcat-versao/webapps") e deixar o arquivo war nessa pasta, feito isso volte para a pasta do tomcat, acesse a pasta bin ache e execute o arquivo startup.bat, que vai rodar o tomcat e subir a aplicação, pronto, agora é só abrir o navegador e acessar http://localhost:8080/telephonebook/contato/home.
</p>
<h2>Banco de dados</h2>
<p>Para realizar todas as operações da aplicação é necessário ter o MySQL instalado na sua máquina, banco com nome "telephonebook", user e password "root".
	Caso a tabela não seja gerada automáticamente, é necessário cria uma tabela contato, com id, email, name e phone.</p>