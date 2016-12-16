using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Client_one
{
    public class main
    {
        static void Main(string[] args)
        {
            IJSimpCalcWebService web = new IJSimpCalcWebService();
            Console.Write(web.addition("testing"));
            Console.ReadKey();
        }
    }
}
