# Room Temperature Analyzer

A Java application that processes room temperature data and generates statistical summaries.

## 📋 Description

This project analyzes temperature readings from multiple rooms and provides:
- Per-room average temperatures
- Overall average temperature across all rooms
- Identification of the hottest room

The application reads temperature data from a CSV file (`roomtemps.txt`) and outputs a formatted summary to `temps_summary.txt`.

## 🚀 Features

- **Data Processing**: Reads room temperature data from CSV format
- **Statistical Analysis**: Calculates averages for individual rooms and overall
- **Hot Room Detection**: Identifies the room with the highest average temperature
- **Formatted Output**: Generates a clean, readable summary report
- **Error Handling**: Includes proper exception handling for file operations

## 📁 Project Structure

```
Files/
├── src/files/
│   └── Files.java          # Main application class
├── roomtemps.txt           # Input data file
├── temps_summary.txt       # Generated output file
├── build.xml              # NetBeans build configuration
└── README.md              # This file
```

## 🔧 Requirements

- Java 8 or higher
- NetBeans IDE (optional, for development)

## 📊 Input Format

The input file (`roomtemps.txt`) should contain temperature data in CSV format:
```
RoomID,Temp1,Temp2,Temp3,Temp4,Temp5
A101,21.5,22.0,21.8,22.1,21.9
B202,23.0,22.7,22.9,23.1,22.8
```

## 📈 Output Format

The application generates a summary file (`temps_summary.txt`) with:
```
Per-room averages:
A101: 21.86
B202: 22.90
...

Overall average: 22.380
Hottest room: B202 (22.9)
```

## 🚀 How to Run

### Using NetBeans:
1. Open the project in NetBeans
2. Right-click on the project and select "Run"

### Using Command Line:
1. Compile the Java file:
   ```bash
   javac -d . src/files/Files.java
   ```
2. Run the application:
   ```bash
   java files.Files
   ```

## 📝 Sample Data

The project includes sample temperature data for 4 rooms (A101, B202, C303, D404) with 5 temperature readings each.

## 🛠️ Development

This is a NetBeans project with standard Java structure. The main logic is contained in the `Files.java` class within the `files` package.

## 📄 License

This project is open source and available under the MIT License.

## 👨‍💻 Author

Created as a Java file processing exercise for temperature data analysis.
