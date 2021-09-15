import { Injectable, EventEmitter } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';

@Injectable({
  providedIn: 'root'
})
export class DataSharingService {
  
  data : Number;
  dataObj:any;
  status: string;
  list: any[];
  invokeFirstComponentFunction = new EventEmitter();    
  subsVar: Subscription;    
    
  constructor() { }    
    
  onFirstComponentButtonClick() {    
    this.invokeFirstComponentFunction.emit();    
  } 
}
