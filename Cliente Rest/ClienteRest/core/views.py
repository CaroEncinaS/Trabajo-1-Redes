from django.shortcuts import render, HttpResponse
import requests, urllib
import json

# Create your views here.

def home(request):
    if request.POST.get('rut'):
        informacion=request.POST.get('rut')
        rut=str(informacion)
        response= requests.get('http://localhost:8080/ProyectoRedes/app/verificarut?rut='+rut)
        if response.status_code==200:
            data= response.json()
            print(data[0]['valido'])
            print(response)
            return render(request, "core/home.html",{
                'rutvalido':data[0]['valido'],
            })
        else:
            return render(request, "core/home.html")
    elif request.POST.get('nombres'):
        nombres=str(request.POST.get('nombres'))
        apellidopat=str(request.POST.get('ApellidoP'))
        apellidomat=str(request.POST.get('ApellidoM'))
        sexo=str(request.POST.get('sexo'))
        response= requests.get('http://localhost:8080/mavenproject1/app/verificarut?rut='+rut)
        if response.status_code==200:
            data= response.json()
            print(data[0]['valido'])
            print(response)
            return render(request, "core/home.html",{
                'rutvalido':data[0]['valido'],
            })
        else:
            return render(request, "core/home.html")
    else:
        return render(request, "core/home.html")