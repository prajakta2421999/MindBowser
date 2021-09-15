import { Injectable } from '@angular/core';
import { MainURL } from 'src/app/constants/configUrl';
import { HttpClient, HttpHeaders } from '@angular/common/http';

 

var headers_object = new HttpHeaders();
    headers_object.append('Content-Type', 'application/json');
    var headers_object = new HttpHeaders().set("Token", sessionStorage.getItem("token"));
    const httpOptions = {
      headers: headers_object
    };

@Injectable({
  providedIn: 'root'
})


export class HttpmethodsService {

  baseUrl = MainURL.HostUrl;
  constructor(private http : HttpClient) { 

  }

  postRequest(url,body) {
    return this.http.post(this.baseUrl+url,body)
  }

  getRequest(url){
    return this.http.get(this.baseUrl+url,{headers:headers_object})
  }

  putRequest(url,body){
    return this.http.put(this.baseUrl+url,body)
  }

  deleteRequest(url){
    return this.http.delete(this.baseUrl+url)
  }

  public fileUpload(url:  string,formData: File)
  {
   
    const uploadfile: FormData = new FormData();  
    
    uploadfile.append('uploadfile', formData);  
   
    return this.http.post(this.baseUrl+url, uploadfile);
   }

   postRequestJasper(url,body) {
    
    return this.http.post(this.baseUrl+url,body,{responseType: 'arraybuffer'})
  }

  getRequestJasper(url){
    return this.http.get(this.baseUrl+url,{responseType:"arraybuffer"})
  }



}
