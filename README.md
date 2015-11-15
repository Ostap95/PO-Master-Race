# edt
Antes de compilar:  Meter a pasta e os jars separadamente no ambiente de trabalho
Compilar o projecto: javac -cp po-uilib.jar:.:edt-support.jar `find edt -name *.java`
Executar o projecto: java -cp po-uilib.jar:.:edt-support.jar edt.textui.Editor
