# Simple Drawing Tool

This Java project, `App.java`, is a simple drawing tool that allows users to draw various shapes on a frame by clicking buttons. It utilizes the Factory pattern to handle the creation of different shapes and introduces a `ShapeFactory` class for managing the creation process.

## Overview

The application consists of a JFrame (window) with a drawing panel, buttons for different shapes, a toolbar, and a color selection panel. Users can select a shape by clicking the corresponding button and then click on the drawing panel to create instances of that shape.

## Features

- **Drawing Shapes**: Click on the buttons (Circle, Rectangle, Line, Triangle, Star, Hexagon) to select a shape, then click on the drawing panel to create instances of the selected shape.

- **Color Selection**: Click on the "Choose Color" button to open a color chooser dialog and select the color for the shapes.

- **Save Drawing**: Click on the "Save" button to save the drawing as a PNG image. The user can choose the file location and specify the file name.

## Usage

1. **Select Shape**: Click on one of the shape buttons in the toolbar to choose the shape you want to draw.

2. **Draw Shapes**: Click on the drawing panel to create instances of the selected shape.

3. **Change Color**: Click on the "Choose Color" button to change the color of the shapes.

4. **Save Drawing**: Click on the "Save" button to save the drawing as a PNG image.

## Structure

The project consists of a `SamplePanel` class (drawing panel) within the `App` class. The `SamplePanel` class handles mouse events and drawing shapes on the panel. The `ShapeFactory` class is used to create different shape objects based on user input.

## Dependencies

- Java's AWT and Swing libraries are used for GUI components and drawing.
- The project includes icons for each shape in the "../icon/" directory.

## How to Run

1. Compile and run the Java program using a Java compiler.

```bash
javac App.java
java App
```

2. The application window will appear, and you can start drawing shapes.

## Contributing

Contributions to the project are welcome. Feel free to open issues, submit pull requests, or suggest improvements.
