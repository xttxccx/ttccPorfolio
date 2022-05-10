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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
