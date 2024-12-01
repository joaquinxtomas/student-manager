<h1>Gestor de Estudiantes</h1>

<h2>Descripción</h2>
<p>Este es un programa en Java para gestionar estudiantes, que utiliza una base de datos MySQL. Proporciona funcionalidades básicas para listar, agregar, buscar, modificar y eliminar registros de estudiantes a través de un menú en la consola.</p>

<h2>Funcionalidades</h2>
<ul>
        <li><strong>Listar todos los estudiantes:</strong> Muestra una lista completa de estudiantes registrados.</li>
        <li><strong>Agregar un nuevo estudiante:</strong> Permite ingresar los datos de un nuevo estudiante.</li>
        <li><strong>Buscar un estudiante por su ID:</strong> Recupera los detalles de un estudiante específico mediante su ID.</li>
        <li><strong>Modificar datos de un estudiante:</strong> Actualiza la información de un estudiante existente.</li>
        <li><strong>Eliminar un estudiante:</strong> Elimina un estudiante de la base de datos tras confirmación.</li>
</ul>

<h2>Requisitos previos</h2>
<ul>
        <li>Java 8 o superior.</li>
        <li>MySQL Server.</li>
        <li>Conexión a la base de datos configurada correctamente.</li>
</ul>

<h2>Instalación</h2>
<ol>
        <li>Clona este repositorio:
            <pre><code>git clone (https://github.com/joaquinxtomas/student-manager)</code></pre>
        </li>
        <li>Configura la conexión a MySQL en tu código Java:
            <pre><code>// Ejemplo de configuración
String url = "jdbc:mysql://localhost:3306/nombre_base_datos";
String user = "usuario";
String password = "contraseña";</code></pre>
        </li>
        <li>Asegúrate de tener la base de datos y la tabla necesarias:
            <pre><code>CREATE DATABASE gestion_estudiantes;

CREATE TABLE estudiantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    telefono VARCHAR(15),
    email VARCHAR(50)
);</code></pre>
        </li>
    </ol>

<h2>Uso</h2>
<p>Compila y ejecuta el programa desde tu entorno de desarrollo o terminal. En la consola, selecciona una de las opciones del menú:</p>
<pre><code>*** GESTIÓN DE ESTUDIANTES ***
1. Listar todos los estudiantes.
2. Agregar un nuevo estudiante.
3. Buscar un estudiante por su ID.
4. Modificar datos de un estudiante.
5. Eliminar un estudiante.
6. Salir.
Elige una opción:</code></pre>

<h2>Contribuciones</h2>
<p>Las contribuciones son bienvenidas. Para contribuir:</p>
<ol>
        <li>Realiza un fork del repositorio.</li>
        <li>Crea una nueva rama: <code>git checkout -b feature/nueva-funcionalidad</code></li>
        <li>Realiza tus cambios y confirma: <code>git commit -am "Añadir nueva funcionalidad"</code></li>
        <li>Haz un push a la rama: <code>git push origin feature/nueva-funcionalidad</code></li>
        <li>Abre una solicitud de extracción.</li>
</ol>


