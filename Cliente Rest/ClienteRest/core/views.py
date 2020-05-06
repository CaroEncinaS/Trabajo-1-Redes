from django.shortcuts import render, HttpResponse
import requests, urllib, json
from zeep import Client

# Create your views here.

def home(request):
    return render(request, "core/home.html")

def RestClient(request):
    if request.POST.get('rut'):
        informacion=request.POST.get('rut')
        rut=str(informacion)
        response= requests.get('http://localhost:8080/ProyectoRedes/app/verificarut?rut='+rut)
        if response.status_code==200:
            data= response.json()
            return render(request, "core/restapi.html",{
                'rutvalido':data[0]['valido'],
            })
        else:
            return render(request, "core/restapi.html")
    elif request.POST.get('nombres'):
        nombres=str(request.POST.get('nombres'))
        apellidopat=str(request.POST.get('apellidop'))
        apellidomat=str(request.POST.get('apellidom'))
        sexo=str(request.POST.get('sexo'))
        response= requests.get('http://localhost:8080/ProyectoRedes/app/saludo?nombres='+nombres+"&apellidop="+apellidopat+"&apellidom="+apellidomat+"&sexo="+sexo)
        if response.status_code==200:
            data= response.json()
            return render(request, "core/restapi.html",{
                'saludo':data[0]['saludo'],
            })
        else:
            return render(request, "core/restapi.html")
    else:
        return render(request, "core/restapi.html")

def SoapClient(request):
    if request.POST.get('rut'):
        informacion=request.POST.get('rut')
        rut=str(informacion)
        client= Client('http://localhost:59955/Service.asmx?wsdl')
        response_content=response=client.service.Verificacion(rut)
        with client.settings(raw_response=True):
            response=client.service.Verificacion(rut)
            assert response.status_code==200
            assert response.content
        if (response.status_code==200):
            return render(request, "core/apisoap.html",{
                'rutvalido':response_content,
            })
        else:
            return render(request, "core/apisoap.html")
    
    elif request.POST.get('nombres'):
        nombres=str(request.POST.get('nombres'))
        apellidopat=str(request.POST.get('apellidop'))
        apellidomat=str(request.POST.get('apellidom'))
        sexo=str(request.POST.get('sexo'))
        client= Client('http://localhost:59955/Service.asmx?wsdl')
        response_content= client.service.Saludos(apellidopat,apellidomat,nombres,sexo)
        with client.settings(raw_response=True):
            response=client.service.Saludos(apellidopat,apellidomat,nombres,sexo)
            assert response.status_code==200
            assert response.content
        if(response.status_code==200):  
            print(response_content)
            return render(request, "core/apisoap.html",{
                'saludo':response_content
            })
        else:
            return render(request, "core/apisoap.html")

    else:
        return render(request, "core/apisoap.html")