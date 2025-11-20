# Colección de Postman - Apuntes Mecánica API

Esta colección contiene todos los endpoints de la API de Apuntes Mecánica para facilitar las pruebas y el desarrollo.

## 📋 Contenido

La colección incluye los siguientes grupos de endpoints:

### 1. **Mechanics** (Mecánicos)
- Crear mecánico
- Obtener todos los mecánicos
- Obtener mecánico por ID
- Actualizar mecánico
- Eliminar mecánico
- Buscar por username, email o documento

### 2. **Vehicle Owners** (Propietarios)
- Crear propietario
- Obtener todos los propietarios
- Obtener propietario por ID
- Actualizar propietario
- Eliminar propietario
- Buscar por username, email o documento

### 3. **Vehicles** (Vehículos)
- Crear vehículo
- Obtener todos los vehículos
- Obtener vehículo por ID
- Actualizar vehículo
- Eliminar vehículo
- Buscar por placa, chasis o propietario
- Verificar existencia de placa

### 4. **Procedures** (Procedimientos)
- Crear procedimiento
- Obtener todos los procedimientos
- Obtener procedimiento por ID o código
- Actualizar procedimiento
- Eliminar procedimiento
- Buscar por vehículo o nombre
- Verificar existencia de código

### 5. **Notifications** (Notificaciones)
- Crear notificación
- Obtener todas las notificaciones
- Obtener notificación por ID
- Actualizar notificación
- Eliminar notificación
- Buscar por vehículo, procedimiento o estado
- Obtener notificaciones recientes

## 🚀 Cómo usar

### Importar la colección en Postman

1. Abre Postman
2. Haz clic en **Import** (botón en la esquina superior izquierda)
3. Selecciona el archivo `Apuntes_Mecanica_API.postman_collection.json`
4. La colección se importará con todos los endpoints organizados

### Configurar la URL base

La colección usa una variable `base_url` que está configurada por defecto como:
```
http://localhost:8080/api
```

Para cambiar la URL base:
1. Haz clic en la colección "Apuntes Mecánica API"
2. Ve a la pestaña **Variables**
3. Modifica el valor de `base_url` según tu entorno:
   - Desarrollo: `http://localhost:8080/api`
   - Producción: `https://tu-dominio.com/api`

### Ejemplos de uso

#### Crear un Mecánico
```json
POST {{base_url}}/mechanics
{
  "rol": "MECANICO",
  "username": "juan_mechanic",
  "password": "password123",
  "email": "juan@taller.com",
  "tipoDocumento": "CC",
  "numeroDoc": 12345678,
  "telefono": 3001234567,
  "direccionTaller": "Calle 123 #45-67",
  "telefonoTaller": "6012345678",
  "nombreTaller": "Taller Juan",
  "horarioAtencion": "Lun-Vie 8:00-18:00",
  "especialidades": ["MECANICO", "MOTORES", "FRENOS"]
}
```

#### Crear un Vehículo
```json
POST {{base_url}}/vehicles
{
  "plate": "ABC123",
  "cylinderCapacity": "1600cc",
  "color": "Rojo",
  "chassisNumber": "CH123456789",
  "model": 2020,
  "kilometraje": 50000,
  "vehicleOwner": {
    "id": 1
  }
}
```

#### Crear un Procedimiento
```json
POST {{base_url}}/procedures
{
  "name": "Cambio de aceite",
  "duration": 60,
  "date": "2024-01-15",
  "note": 5,
  "vehicle": {
    "id": 1
  },
  "mechanic": {
    "id": 1
  }
}
```

## 📝 Notas importantes

### Especialidades de Mecánico
Los valores válidos para `especialidades` son:
- `MECANICO`
- `ELECTRICO`
- `MOTORES`
- `SUSPENSION`
- `TRANSMISION`
- `FRENOS`
- `CLIMATIZACION`
- `CARROCERIA`
- `PINTURA`
- `DIAGNOSTICO`

### Estados de Notificación
Los valores válidos para `status` en notificaciones son:
- `PENDING` - Pendiente
- `SENT` - Enviada
- `COMPLETED` - Completada

### Relaciones entre entidades

- **Vehicle** requiere un `vehicleOwner` (id del propietario)
- **Procedure** requiere un `vehicle` (id del vehículo) y un `mechanic` (id del mecánico)
- **Notification** requiere un `vehicle` (id del vehículo) y un `procedure` (código del procedimiento)

## 🔧 Requisitos

- Postman instalado (versión 7.0 o superior)
- API ejecutándose en `http://localhost:8080` (o ajustar la variable `base_url`)

## 📚 Estructura de la API

Todos los endpoints siguen el patrón REST:
- `GET` - Obtener recursos
- `POST` - Crear recursos
- `PUT` - Actualizar recursos
- `DELETE` - Eliminar recursos

Los códigos de respuesta HTTP utilizados:
- `200 OK` - Operación exitosa
- `201 Created` - Recurso creado exitosamente
- `204 No Content` - Recurso eliminado exitosamente
- `400 Bad Request` - Solicitud inválida
- `404 Not Found` - Recurso no encontrado

