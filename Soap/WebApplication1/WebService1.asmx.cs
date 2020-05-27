using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace WebApplication1
{
    /// <summary>
    /// Summary description for WebService1
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class WebService1 : System.Web.Services.WebService
    {
        [WebMethod]
        public bool Verificacion(string rut)
        {
            rut = rut.ToUpper();
            rut = rut.Replace(".", "");
            rut = rut.Replace("-", "");
            if (rut.Length == 9)
            {
                int rutaux = int.Parse(rut.Substring(0, rut.Length - 1));
                char dv = char.Parse(rut.Substring(rut.Length - 1, 1));
                int cont = 0;
                int i = 2;
                while (i < 8)
                {
                    cont = cont + ((rutaux % 10) * i);
                    rutaux = rutaux / 10;
                    i++;
                }
                int j = 2;
                while (j < 4)
                {
                    cont = cont + ((rutaux % 10) * j);
                    rutaux = rutaux / 10;
                    j++;
                }
                int cont2 = cont % 11;
                int cont3 = 11 - cont2;
                int b = (dv - '0');
                if (b == 27)
                {
                    b = 10;
                }

                else if (b == 0)
                {
                    b = 11;
                }
                else { }
                if (cont3 == b)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else if (rut.Length == 8)
            {
                int rutaux = int.Parse(rut.Substring(0, rut.Length - 1));
                char dv = char.Parse(rut.Substring(rut.Length - 1, 1));
                int cont = 0;
                int i = 2;
                while (i < 8)
                {
                    cont = cont + ((rutaux % 10) * i);
                    rutaux = rutaux / 10;
                    i++;
                }
                int j = 2;
                while (j < 3)
                {
                    cont = cont + ((rutaux % 10) * j);
                    rutaux = rutaux / 10;
                    j++;
                }
                int cont2 = cont % 11;
                int cont3 = 11 - cont2;
                int b = (dv - '0');
                if (b == 27)
                {
                    b = 10;
                }

                else if (b == 0)
                {
                    b = 11;
                }
                else { }
                if (cont3 == b)
                {
                    return true;
                }
                else
                {
                    return false;
                }

            }
            else
            {
                return false;
            }
        }
        [WebMethod]
        public string Saludos(string ap, string am, string nbs, string genero)
        {
            ap = ap.ToLower();
            am = am.ToLower();
            nbs = nbs.ToLower();
            genero = genero.ToUpper();
            string h = "Saludos Sr:";
            string m = "Saludos Sra: ";
            string a = "ERROR faltan campos";
            string c = "Nombre muy largo";
            if (ap != "" && am != "" && nbs != "" && genero != "")
            {
                if (genero == "F" || genero == "MUJER" || genero == "FEMENINO")
                {
                    string ap1 = ap.Substring(0, 1);
                    ap = ap.Substring(1, ap.Length - 1);
                    string am1 = am.Substring(0, 1);
                    am = am.Substring(1, am.Length - 1);
                    string[] arr = nbs.Split(" ".ToCharArray(), StringSplitOptions.RemoveEmptyEntries);

                    if (arr.Length < 2)
                    {
                        string x = arr[0];
                        string x1 = x.Substring(0, 1);
                        x = x.Substring(1, x.Length - 1);

                        return m + " " + x1.ToUpper() + x + " " + ap1.ToUpper() + ap + " " + am1.ToUpper() + am + " ";

                    }
                    else if (arr.Length == 2)
                    {
                        string x = arr[0];
                        string x1 = x.Substring(0, 1);
                        x = x.Substring(1, x.Length - 1);
                        string y = arr[1];
                        string y1 = y.Substring(0, 1);
                        y = y.Substring(1, y.Length - 1);

                        return m + " " + x1.ToUpper() + x + " " + y1.ToUpper() + y + " " + ap1.ToUpper() + ap + " " + am1.ToUpper() + am + " ";
                    }
                    else if (arr.Length == 3)
                    {
                        string x = arr[0];
                        string x1 = x.Substring(0, 1);
                        x = x.Substring(1, x.Length - 1);
                        string y = arr[1];
                        string y1 = y.Substring(0, 1);
                        y = y.Substring(1, y.Length - 1);
                        string z = arr[2];
                        string z1 = z.Substring(0, 1);
                        z = z.Substring(1, z.Length - 1);
                        return m + " " + x1.ToUpper() + x + " " + y1.ToUpper() + y + " " + z1.ToUpper() + z + " " + ap1.ToUpper() + ap + " " + am1.ToUpper() + am + " ";


                    }
                    else
                    {
                        return c;
                    }
                }
                else if (genero == "M" || genero == "HOMBRE" || genero == "MASCULINO")
                {
                    {
                        string ap1 = ap.Substring(0, 1);
                        ap = ap.Substring(1, ap.Length - 1);
                        string am1 = am.Substring(0, 1);
                        am = am.Substring(1, am.Length - 1);
                        string[] arr = nbs.Split(" ".ToCharArray(), StringSplitOptions.RemoveEmptyEntries);

                        if (arr.Length < 2)
                        {
                            string x = arr[0];
                            string x1 = x.Substring(0, 1);
                            x = x.Substring(1, x.Length - 1);

                            return h + " " + x1.ToUpper() + x + " " + ap1.ToUpper() + ap + " " + am1.ToUpper() + am + " ";
                        }
                        else if (arr.Length == 2)
                        {
                            string x = arr[0];
                            string x1 = x.Substring(0, 1);
                            x = x.Substring(1, x.Length - 1);
                            string y = arr[1];
                            string y1 = y.Substring(0, 1);
                            y = y.Substring(1, y.Length - 1);

                            return h + " " + x1.ToUpper() + x + " " + y1.ToUpper() + y + " " + ap1.ToUpper() + ap + " " + am1.ToUpper() + am + " ";
                        }
                        else if (arr.Length == 3)
                        {
                            string x = arr[0];
                            string x1 = x.Substring(0, 1);
                            x = x.Substring(1, x.Length - 1);
                            string y = arr[1];
                            string y1 = y.Substring(0, 1);
                            y = y.Substring(1, y.Length - 1);
                            string z = arr[2];
                            string z1 = z.Substring(0, 1);
                            z = z.Substring(1, z.Length - 1);
                            return h + " " + x1.ToUpper() + x + " " + y1.ToUpper() + y + " " + z1.ToUpper() + z + " " + ap1.ToUpper() + ap + " " + am1.ToUpper() + am + " ";


                        }
                        else
                        {
                            return c;
                        }



                    }
                }
                else
                {
                    return a;
                }
            }
            else
            {
                return a;
            }

        }
    }
}



