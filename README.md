# Linear-System-Solver
A java-based tool for linear systems using Gaussian Elimination and Gauss-Jordan Reduction, including partial pivoting.


## Feature  
- **Gaussian Elimination** with partial pivoting for numerical stability
- **Gauss-Jordan Reduction** for finding reduced row echelan form
- **Matrix validation** to ensure proper input dimensions
- **Determinant calculation** during the elimination process
- **Multiple solution types** detection (unique, infinite, or no solution)
- **User-frindly input** handling for matrices and vectores
- **Formatted output** for easy result interpretation

## Technologies
- Java 17+

## Project Structure

linear-system-solver/
├── Main.java
─── solver/

    ├── EliminacaoGauss.java
    ├── GaussJordan.java
    ├── InputHandler.java
    └── Utils.java

## Installation

1. Clone the repository:

    >git clone https://github.com/rlkbruno-05/linear-system-solver.git
    
    >cd linear-system-solver

2. Compile the Java files:

    javac Main.java solver/*.java

## Usage
Run the application:

    java Main
Follow the interactive prompts to input your matrix and vector values.


## Example

**Input:**
>=== **Linear System Solver** ===

>Digite o número de linhas: 2

>Digite o número de colunas: 2

>
>Digite os valores da matriz:

>Elemento [0][0]: 2

>Elemento [0][1]: 1

>Elemento [1][0]: 1

>Elemento [1][1]: -1

>

>Digite os valores do vetor (b):

>Elemento [0]: 5

>Elemento [1]: 1


**Output:**

>=== **RESULTADOS** ===

>Tipo de solução: Solução única

>Determinante: -3.000

>Solução do sistema:

>x0 =    2.000

>x1 =    1.000

## Solution Types

- Unique solution
- Infinite solutions
- No solution
