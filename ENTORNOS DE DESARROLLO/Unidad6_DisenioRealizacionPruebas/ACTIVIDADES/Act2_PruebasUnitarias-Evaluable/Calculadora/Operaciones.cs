namespace Calculadora
{
    public class Operaciones
    {
        /// <summary>
        /// Suma dos números
        /// </summary>
        /// <param name="a">Primer número</param>
        /// <param name="b">Segundo número</param>
        /// <returns>El resultado de la suma</returns>
        public double Suma(double a, double b)
        {
            return a + b;
        }

        /// <summary>
        /// Resta dos números
        /// </summary>
        /// <param name="a">Minuendo</param>
        /// <param name="b">Sustraendo</param>
        /// <returns>El resultado de la resta</returns>
        public double Resta(double a, double b)
        {
            return a - b;
        }

        /// <summary>
        /// Multiplica dos números
        /// </summary>
        /// <param name="a">Primer número</param>
        /// <param name="b">Segundo número</param>
        /// <returns>El resultado de la multiplicación</returns>
        public double Multiplicar(double a, double b)
        {
            return a * b;
        }

        /// <summary>
        /// Divide dos números
        /// </summary>
        /// <param name="a">Dividendo</param>
        /// <param name="b">Divisor</param>
        /// <returns>El resultado de la división</returns>
        /// <exception cref="ArgumentException">Lanza excepción si el divisor es cero</exception>
        public double Dividir(double a, double b)
        {
            if (b == 0)
            {
                throw new ArgumentException("El divisor no puede ser cero");
            }
            return a / b;
        }

        /// <summary>
        /// Verifica si dos números son iguales
        /// </summary>
        /// <param name="a">Primer número</param>
        /// <param name="b">Segundo número</param>
        /// <returns>True si son iguales, false si no lo son</returns>
        public bool Iguales(double a, double b)
        {
            return a == b;
        }
    }
}
