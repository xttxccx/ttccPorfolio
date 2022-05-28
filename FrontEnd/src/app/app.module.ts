import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { LogoArgProComponent } from './components/logo-arg-pro/logo-arg-pro.component';
import { RedesComponent } from './components/redes/redes.component';
import { BannerComponent } from './components/banner/banner.component';
import { AcercaDeComponent } from './components/acerca-de/acerca-de.component';
import { PerfilComponent } from './components/perfil/perfil.component';
import { DescripcionComponent } from './components/descripcion/descripcion.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { FormacionComponent } from './components/formacion/formacion.component';
import { DocenciaComponent } from './components/docencia/docencia.component';
import { PresentacionesComponent } from './components/presentaciones/presentaciones.component';
import { TrabajoComponent } from './components/trabajo/trabajo.component';
import { ItemComponent } from './components/item/item.component';
import { SkillsComponent } from './components/skills/skills.component';
import { PorcentajeComponent } from './components/porcentaje/porcentaje.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { ProyectoComponent } from './components/proyecto/proyecto.component';
import { ProyectosComponent } from './components/proyectos/proyectos.component';
import { FooterComponent } from './components/footer/footer.component';
import { BotonLoginComponent } from './components/boton-login/boton-login.component';
import { LogosComponent } from './components/logos/logos.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { PortfolioComponent } from './components/portfolio/portfolio.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PortfolioService } from './service/portfolio.service';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoArgProComponent,
    RedesComponent,
    BannerComponent,
    AcercaDeComponent,
    PerfilComponent,
    DescripcionComponent,
    ExperienciaComponent,
    FormacionComponent,
    DocenciaComponent,
    PresentacionesComponent,
    TrabajoComponent,
    ItemComponent,
    SkillsComponent,
    PorcentajeComponent,
    ProyectoComponent,
    ProyectosComponent,
    FooterComponent,
    BotonLoginComponent,
    LogosComponent,
    PortfolioComponent,
    LoginComponent,
  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({}),
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule, 
  ],
  providers: [],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
