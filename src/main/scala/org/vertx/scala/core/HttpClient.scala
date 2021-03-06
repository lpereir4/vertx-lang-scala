/*
 * Copyright 2011-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.vertx.scala.core

import collection.JavaConversions._
import org.vertx.java.core.http.{HttpClient => JHttpClient}
import org.vertx.scala.handlers.FunctionHandler1
import org.vertx.java.core.http.HttpClientResponse
import org.vertx.java.core.http.{WebSocket => JWebSocket}
import org.vertx.java.core.http.{WebSocketVersion => JWebSocketVersion}

class HttpClient(internal: JHttpClient) extends ClientConfigurer {

  def connect(uri: String, handler: (HttpClientResponse) => Unit): Unit = {
    internal.connect(uri, FunctionHandler1(handler))
  }

  def connectWebsocket(uri: String, wsConnect: (JWebSocket) => Unit): Unit = {
    internal.connectWebsocket(uri, FunctionHandler1(wsConnect))
  }

  def connectWebsocket(uri: String, wsVersion: JWebSocketVersion, wsConnect: (JWebSocket) => Unit): Unit = {
    internal.connectWebsocket(uri, wsVersion, FunctionHandler1(wsConnect))
  }

  def delete(uri: String, handler: (HttpClientResponse) => Unit): Unit = {
    internal.delete(uri, FunctionHandler1(handler))
  }

  def exceptionHandler(handler: (Exception) => Unit): Unit = {
    internal.exceptionHandler(FunctionHandler1(handler))
  }

  def get(uri: String, handler: (HttpClientResponse) => Unit): Unit = {
    internal.get(uri, FunctionHandler1(handler))
  }

  def getNow(uri: String, headers: Map[String,_], handler: (HttpClientResponse) => Unit): Unit = {
    internal.getNow(uri, headers, FunctionHandler1(handler))
  }

  def getNow(uri: String, handler: (HttpClientResponse) => Unit): Unit = {
    internal.getNow(uri, FunctionHandler1(handler))
  }

  def head(uri: String, handler: (HttpClientResponse) => Unit): Unit = {
    internal.head(uri, FunctionHandler1(handler))
  }

  def options(uri: String, handler: (HttpClientResponse) => Unit): Unit = {
    internal.options(uri, FunctionHandler1(handler))
  }

  def patch(uri: String, handler: (HttpClientResponse) => Unit): Unit = {
    internal.patch(uri, FunctionHandler1(handler))
  }

  def post(uri: String, handler: (HttpClientResponse) => Unit): Unit = {
    internal.post(uri, FunctionHandler1(handler))
  }

  def put(uri: String, handler: (HttpClientResponse) => Unit): Unit = {
    internal.put(uri, FunctionHandler1(handler))
  }

  def trace(uri: String, handler: (HttpClientResponse) => Unit): Unit = {
    internal.trace(uri, FunctionHandler1(handler))
  }

  def request(method: String, uri: String, handler: (HttpClientResponse) => Unit): Unit = {
    internal.request(method, uri, FunctionHandler1(handler))
  }

  def close(): Unit = internal.close()

  def bossThreads(): Int = internal.getBossThreads()

  def connectTimeout(): Long = internal.getConnectTimeout()

  def keyStorePassword(): String = internal.getKeyStorePassword()

  def keyStorePath(): String = internal.getKeyStorePath()

  def keyStorePassword(keyStorePassword: String): HttpClient.this.type = {
    internal.setKeyStorePassword(keyStorePassword)
    this
  }

  def keyStorePath(keyStorePath: String): HttpClient.this.type = {
    internal.setKeyStorePath(keyStorePath)
    this
  }

  def maxPoolSize():Int = internal.getMaxPoolSize()

  def receiveBufferSize():Int = internal.getReceiveBufferSize()

  def receiveBufferSize(receiveBufferSize: Int):HttpClient.this.type = {
    internal.setReceiveBufferSize(receiveBufferSize)
    this
  }

  def sendBufferSize(): Int = internal.getSendBufferSize()

  def sendBufferSize(sendBufferSize: Int): HttpClient.this.type = {
    internal.setSendBufferSize(sendBufferSize)
    this
  }

  def trafficClass(): Int = internal.getTrafficClass()

  def trafficClass(trafficClass: Int): HttpClient.this.type = {
    internal.setTrafficClass(trafficClass)
    this
  }

  def trustStorePassword(): String = internal.getTrustStorePassword()

  def trustStorePassword(password: String): HttpClient.this.type = {
    internal.setTrustStorePassword(password)
    this
  }

  def trustStorePath(): String = internal.getTrustStorePath()

  def trustStorePath(path: String): HttpClient.this.type = {
    internal.setTrustStorePath(path)
    this
  }

}