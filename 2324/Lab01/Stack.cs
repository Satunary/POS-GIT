using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab01
{
    public class Stack<T>
    {
       private T[] values; // die Daten
       private int topIndex; // Index letzter Eintrag
 /// <summary>
 /// Creates a stack object with size elementes.

 /// </summary>
 /// <param name="size"></param>
 public Stack(int size) {
            if(size <= 0)
            {
                throw new ArgumentNullException("size is 0 or smaller than 0");
            }
            values = new T[size];
            topIndex = 0;
        }
        /// <summary>
        /// Insert a new item x into the stack.
        /// </summary>
        /// <param name="x"></param>
        public void Push(T x) {
            if (x != null) {
                if (topIndex == 0)
                {
                    values[topIndex] = x;

                }
                if (topIndex + 1 < values.Length)
                {
                    topIndex++;
                    values[topIndex] = x;

                }
                else
                {
                    throw new OverflowException("stack is full");
                }
            }
            else
            {
                throw new InvalidOperationException("input may not be null");
            }
            
            
        }
        /// <summary>
        /// Return and remove the most recently inserted item from the stack.
        /// </summary>
        /// <returns>the item</returns>
        
        
        public T Pop() {
            if (topIndex<0 || values[topIndex] == null)
            {
                throw new Exception("stack is empty");
            }
            else
            {
                var temp = values[topIndex];
                topIndex--;
                return temp;
            }
        }
        /// <summary>
        /// Get the most recently inserted item in the stack.
        /// </summary>
        /// <returns>the item</returns>
        public T Top()
        {
            return values[topIndex];
        }
    }
}
