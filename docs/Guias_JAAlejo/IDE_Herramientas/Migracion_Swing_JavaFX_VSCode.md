# **MIGRACIÓN DE SWING A JAVAFX Y PREPARACIÓN DE VS CODE PARA BUILDER GUI | JOSÉ ÁNGEL ALEJO SILLERO**

Esta guía explica cómo migrar aplicaciones Java de **Swing** a **JavaFX**, un framework más moderno para interfaces gráficas. También incluye pasos para preparar **VS Code** con herramientas de diseño visual (como **Scene Builder**) para facilitar el desarrollo de GUIs.

- [**MIGRACIÓN DE SWING A JAVAFX Y PREPARACIÓN DE VS CODE PARA BUILDER GUI | JOSÉ ÁNGEL ALEJO SILLERO**](#migración-de-swing-a-javafx-y-preparación-de-vs-code-para-builder-gui--josé-ángel-alejo-sillero)
  - [**INTRODUCCIÓN**](#introducción)
  - [**PREPARACIÓN DE VS CODE PARA JAVAFX Y BUILDER GUI**](#preparación-de-vs-code-para-javafx-y-builder-gui)
    - [**INSTALACIÓN DE EXTENSIONES**](#instalación-de-extensiones)
    - [**INSTALACIÓN DE SCENE BUILDER**](#instalación-de-scene-builder)
    - [**CONFIGURACIÓN DEL PROYECTO**](#configuración-del-proyecto)
  - [**MIGRACIÓN DE SWING A JAVAFX**](#migración-de-swing-a-javafx)
    - [**DIFERENCIAS CLAVE ENTRE SWING Y JAVAFX**](#diferencias-clave-entre-swing-y-javafx)
    - [**PASOS PARA MIGRAR**](#pasos-para-migrar)
      - [**PASO 1: CREAR UN NUEVO PROYECTO JAVAFX**](#paso-1-crear-un-nuevo-proyecto-javafx)
      - [**PASO 2: MIGRAR COMPONENTES BÁSICOS**](#paso-2-migrar-componentes-básicos)
      - [**PASO 3: MIGRAR EVENTOS Y LÓGICA**](#paso-3-migrar-eventos-y-lógica)
      - [**PASO 4: USAR FXML PARA DISEÑO VISUAL**](#paso-4-usar-fxml-para-diseño-visual)
      - [**PASO 5: PROBAR Y AJUSTAR**](#paso-5-probar-y-ajustar)
    - [**EJEMPLO PRÁCTICO: MIGRAR UN JFRAME SIMPLE**](#ejemplo-práctico-migrar-un-jframe-simple)
  - [**CONSEJOS Y MEJORES PRÁCTICAS**](#consejos-y-mejores-prácticas)
  - [**RECURSOS ADICIONALES**](#recursos-adicionales)

<div style="page-break-after: always;"></div>

## **INTRODUCCIÓN**

**Swing** es un framework legacy para GUIs en Java, basado en AWT, mientras que **JavaFX** es moderno, con mejor rendimiento y soporte multiplataforma. Aprender **Swing** es útil para conceptos básicos, pero **JavaFX** es recomendado para nuevos proyectos. Esta guía cubre la migración y cómo configurar **VS Code** con un builder visual.

**¿Por qué migrar?**

- **Swing** limita el rendimiento en sistemas modernos debido a AWT.
- **JavaFX** ofrece API rica, CSS nativo, animaciones y mejor hardware gráfico.
- Recomendado por Oracle para apps de escritorio, con soporte a largo plazo.

**Beneficios clave:**

- Mejor usabilidad y diseños atractivos.
- Código más fácil de mantener.
- Soporte multiplataforma avanzado.

Esta guía te guía paso a paso, incluyendo herramientas como **Scene Builder** para desarrollo visual.

## **PREPARACIÓN DE VS CODE PARA JAVAFX Y BUILDER GUI**

### **INSTALACIÓN DE EXTENSIONES**

Para desarrollar en **JavaFX**, instala estas extensiones en **VS Code**:

1. **Instala el Extension Pack for Java**.
   - Abre **VS Code**.
   - Ve a Extensiones (icono de cuadrados).
   - Busca "Extension Pack for Java" e instala.
   - Reinicia **VS Code** si es necesario.
   - Incluye soporte para **JavaFX**, IntelliSense y depuración.

2. **Instala extensiones adicionales si necesitas**.
   - Para más soporte **JavaFX**, busca "JavaFX Support".
   - Si usas **Maven**, verifica que "Maven for Java" esté activo (viene incluido).
   - Para **Gradle**, instala "Gradle for Java".

Estas extensiones facilitan el desarrollo con autocompletado y depuración integrada.

### **INSTALACIÓN DE SCENE BUILDER**

**Scene Builder** es una herramienta visual gratuita para diseñar GUIs **JavaFX** (similar al diseñador de **Swing** en **NetBeans**).

1. **Descarga Scene Builder**.
   - Ve a <https://gluonhq.com/products/scene-builder/>.
   - Elige la versión para tu SO (Windows, macOS, Linux).
   - Descarga el instalador (.exe, .dmg o .deb).

2. **Instala y configura en VS Code**.
   - Ejecuta el instalador y sigue los pasos.
   - Para integrar con **VS Code**, instala extensiones como "JavaFX Scene Builder".
   - Configura la ruta: En settings de **VS Code**, busca "javafx.scenebuilder.path" y pon la ruta del ejecutable.

**Scene Builder** permite arrastrar componentes y genera código **FXML** automáticamente, acelerando el diseño de interfaces.

### **CONFIGURACIÓN DEL PROYECTO**

Configura tu proyecto **Maven** para **JavaFX**:

1. **Agrega dependencias JavaFX en pom.xml**.
   - Incluye módulos principales:

     ```xml
     <dependency>
         <groupId>org.openjfx</groupId>
         <artifactId>javafx-controls</artifactId>
         <version>21</version>
     </dependency>
     <dependency>
         <groupId>org.openjfx</groupId>
         <artifactId>javafx-fxml</artifactId>
         <version>21</version>
     </dependency>
     ```

   - Coincide la versión con tu JDK (ej. 21 para JDK 21).

2. **Configura el módulo JavaFX**.
   - Agrega el plugin de compilación en `<build>`:

     ```xml
     <build>
         <plugins>
             <plugin>
                 <groupId>org.apache.maven.plugins</groupId>
                 <artifactId>maven-compiler-plugin</artifactId>
                 <version>3.11.0</version>
                 <configuration>
                     <source>21</source>
                     <target>21</target>
                     <compilerArgs>
                         <arg>--module-path</arg>
                         <arg>${javafx.lib.path}</arg>
                         <arg>--add-modules</arg>
                         <arg>javafx.controls,javafx.fxml</arg>
                     </compilerArgs>
                 </configuration>
             </plugin>
         </plugins>
     </build>
     ```

   - Define `javafx.lib.path` apuntando al directorio lib de **JavaFX** (descárgalo de <https://gluonhq.com/products/javafx/> si no viene con el JDK).
   - Ejecuta con `mvn clean compile exec:java` y configura el main class.

Esta configuración integra **JavaFX** en tu proyecto para compilar y ejecutar GUIs modernas.

## **MIGRACIÓN DE SWING A JAVAFX**

### **DIFERENCIAS CLAVE ENTRE SWING Y JAVAFX**

Aprende las diferencias principales para migrar correctamente:

- **Arquitectura**:
  - **Swing** usa AWT para rendering, con posibles problemas de rendimiento.
  - **JavaFX** tiene su propio motor Prism, optimizado para hardware moderno y soporte 3D básico.

- **Componentes**:
  - Nombres similares pero sin prefijo 'J' en **JavaFX** (e.g., JButton → Button).
  - **JavaFX** soporta propiedades observables y bindings para actualizaciones automáticas.

- **Eventos**:
  - **Swing** usa listeners (e.g., addActionListener).
  - **JavaFX** usa handlers (e.g., setOnAction) y soporta gestos avanzados.

- **Estilos**:
  - **JavaFX** soporta CSS nativo para temas personalizados.
  - **Swing** usa Look and Feel limitado.

Recuerda: **JavaFX** es más flexible y moderno, pero requiere aprender nuevos conceptos.

### **PASOS PARA MIGRAR**

#### **PASO 1: CREAR UN NUEVO PROYECTO JAVAFX**

1. **Crea una clase que extienda Application**.
   - Ejemplo básico:

     ```java
     public class MainApp extends Application {
         @Override
         public void start(Stage primaryStage) {
             // Código aquí
         }
         public static void main(String[] args) { launch(args); }
     }
     ```

   - Esto reemplaza el main de **Swing**.

- La clase principal debe extender `Application` y sobrescribir `start(Stage)`. El `Stage` es equivalente al `JFrame` de **Swing**.
- Llama a `launch(args)` en `main` para iniciar la aplicación.

#### **PASO 2: MIGRAR COMPONENTES BÁSICOS**

Migra los componentes principales:

- JFrame → Stage
- JPanel → VBox/HBox/Pane
- JButton → Button
- JTextField → TextField

- **Stage**: Ventana principal, configura título, icono y tamaño.
- **VBox/HBox**: Layouts verticales/horizontales para organizar componentes.
- **Button/TextField**: Componentes básicos con estilos CSS.

Recuerda: **JavaFX** usa layouts basados en nodos para flexibilidad.

#### **PASO 3: MIGRAR EVENTOS Y LÓGICA**

Cambia los eventos:

- **Swing**: `button.addActionListener(e -> ...)`
- **JavaFX**: `button.setOnAction(e -> ...)`

- Los eventos en **JavaFX** soportan lambdas y bindings reactivos.
- Para lógica compleja, usa `ChangeListener` en propiedades observables.

#### **PASO 4: USAR FXML PARA DISEÑO VISUAL**

1. **Crea archivos .fxml con Scene Builder**.
   - Arrastra componentes para generar XML automáticamente.

2. **Carga en código**.
   - Usa: `FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));`

- Separa lógica (Java) de vista (FXML) con `fx:controller`.

#### **PASO 5: PROBAR Y AJUSTAR**

1. **Ejecuta y compara con Swing**.
   - Ajusta layouts y estilos.

2. **Prueba en diferentes resoluciones**.
   - Usa CSS para consistencia.
   - Verifica eventos y bindings.

Consejo: Migra gradualmente para evitar errores.

### **EJEMPLO PRÁCTICO: MIGRAR UN JFRAME SIMPLE**

**Código Swing original:**

```java
JFrame frame = new JFrame("Hola");
JPanel panel = new JPanel();
JButton button = new JButton("Click");
panel.add(button);
frame.add(panel);
frame.setVisible(true);
```

- `JFrame` es la ventana, `JPanel` el contenedor, `JButton` el componente. Layout manual.

**Código JavaFX migrado:**

```java
Stage stage = new Stage();
VBox vbox = new VBox();
Button button = new Button("Click");
vbox.getChildren().add(button);
Scene scene = new Scene(vbox, 300, 200);
stage.setScene(scene);
stage.show();
```

- `Stage` reemplaza `JFrame`, `VBox` organiza verticalmente, `Scene` contiene nodos. Más declarativo.

**Agrega evento:**

```java
button.setOnAction(e -> System.out.println("¡Botón clickeado!"));
```

Los eventos en **JavaFX** son simples y potentes.

## **CONSEJOS Y MEJORES PRÁCTICAS**

Sigue estos consejos para una migración exitosa:

1. **Aprende Swing primero**.
   - Bases sólidas facilitan la transición a **JavaFX**.

2. **Usa Scene Builder para prototipos**.
   - Acelera diseños visuales complejos.

3. **Elige JavaFX para proyectos modernos**.
   - Mejor soporte futuro que **Swing** para legacy.

4. **Documenta cambios**.
   - Rastrea problemas durante la migración.

5. **Prueba en múltiples plataformas**.
   - **JavaFX** es multiplataforma.

6. **Usa bindings para UI automática**.
   - Ejemplo: `button.textProperty().bind(model.textProperty())`.

7. **Evita mezclar Swing y JavaFX**.
   - Previene conflictos en el proyecto.

## **RECURSOS ADICIONALES**

- Documentación **JavaFX**: <https://openjfx.io/>
  - Guías oficiales, API y tutoriales de Oracle.
- Tutoriales: Gluon website (<https://gluonhq.com/>).
  - Ejemplos prácticos y soporte comunitario.
- Comparación **Swing** vs **JavaFX**: Oracle docs (<https://docs.oracle.com/javase/8/javafx/overview/overview.htm>).
  - Detalles técnicos sobre diferencias.
- Libros recomendados: "JavaFX for Dummies" o "Pro JavaFX" para aprendizaje profundo.
- Comunidades: Foros de Stack Overflow, Reddit (r/javafx) para preguntas específicas.
