using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Client_one;
using System.Runtime.Serialization.Formatters.Soap;


namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            Animal a = new Animal(1, "cow", 200);
            ITest web = new ITest();
            web.send(a);
           
        }
    }
}
