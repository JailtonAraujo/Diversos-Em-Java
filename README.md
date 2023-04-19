# Diversos-Em-Java
 Estudo De Diferentes Assuntos Sobre Linguagem Java

# Problemas comuns e resoluções:

* **JasperReport não consegue ler os atrbutos das classes do .jar importado:**
Solução: Provavelmente é um comflito de versão do jdk o jasperReport vem por padrão com a v 11 do java, então e necessario informar o jdk que esta instalado no computado
Isso pode ser feito atravez do arquivo **Jaspersoft Studio.ini** da seguinte forma:

-vm <br> 
C:\Program Files\Java\jdk-17\bin\
