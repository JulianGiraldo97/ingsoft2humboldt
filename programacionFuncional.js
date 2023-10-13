const numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

// Usando map para duplicar cada número
const numerosDuplicados = numeros.map(numero => numero * 2);

// Usando filter para seleccionar solo los números pares
const numerosPares = numerosDuplicados.filter(numero => numero % 2 === 0);

// Usando reduce para sumar los números
const sumaTotal = numerosPares.reduce((acumulador, numero) => acumulador + numero, 0);

console.log("Números originales:", numeros);
console.log("Números duplicados:", numerosDuplicados);
console.log("Números pares:", numerosPares);
console.log("Suma total de números pares:", sumaTotal);
